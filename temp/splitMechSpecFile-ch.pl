#!/usr/local/bin/perl
#
# $Id: //spi/asr-send/asog30/docs/scripts/splitMechSpecFile.pl#1 $

print "starting perl execution";
@ARGV || &usage;
@SAVEARGV=@ARGV;

use File::Basename;
$timestamp=scalar(localtime);
@datetime=localtime;
$dt=join '',
  sprintf("%02d",$datetime[5]-100),
  sprintf("%02d",$datetime[4]+1),
  sprintf("%02d",$datetime[3]),
  ".",
  sprintf("%02d",$datetime[2]),
  sprintf("%02d",$datetime[1]),
  sprintf("%02d",$datetime[0]);	# this is yymmdd.hhmmss

# defaults
$pollingsleeptime=5;
$DEBUG=0;
$INBOX='';
$FILE_PREFIX='';
$SEMAPHORE_LOCKFILE='.__mechspeclockfile__';

#========================================================================
# Parse input args
#========================================================================

while (@ARGV) {
  $_=shift;
  /^-h(elp)?$/ && do {
	&usage;
  };
  /^-debug$/ && do {
	$DEBUG=1;
	next;
  };
  /^-pollingsleeptime$/ && do {
	$pollingsleeptime=shift;
	next;
  };
  /^-.*$/ && do {
	print "!!! ERROR: $_: Bad option\n";
	&usage;
  };
  # default
  push @myargs, $_;
}

($INBOX,$OUTBOX,$FILE_PREFIX)=($myargs[0],$myargs[1],$myargs[2]);
($INBOX && $OUTBOX && $FILE_PREFIX) || do {
  print "!!! ERROR: not enough args\n";
  &usage;
};

# make sure the directory args exist
-d "$INBOX" || die "!!! ERROR: $INBOX is not a valid directory";
-d "$OUTBOX" || die "!!! ERROR: $OUTBOX is not a valid directory";

$INBOX_PARENT_DIR=&dirname("$INBOX");

print "TIMESTAMP: $timestamp\n";

#========================================================================
# Main
#========================================================================

# get a list of files that are not being written to.
(@FILES=&pollfiles) || do {
  print "!!! No files match $INBOX/$FILE_PREFIX\*\n";
  print "... Exiting\n";
  &cleanup;
};


logfile(" Started just now ...");


# process each batch file found
for $file (@FILES) {

  print "... Processing batch file: $file\n";
  logfile("processing batch file: $file\n");

  open(FH,"$file") || do {
	print "!!! ERROR: Can't open $file\n";
	print "... Exiting\n";
	&cleanup;
  };

  # create one big 'ol string from the whole file
  $wholefile='';
  while (<FH>) {
	# remove any CRLFs
	s/[\r\n]//g;
	# concatenate to one line
	$wholefile.=$_;
  }
  close FH;

  # split string into 1200 byte lines
  @lines=();
  while ($wholefile) {
	push @lines, substr($wholefile,0,1200,'');
  }

  $FOUND_HEADER=0;
  $lineno=0;

  # create mechspec records hash of array tables
  %mechspec_records=();
  $rec_count=0;

  $mechspec_header='';
  $curr_line='';
  $prev_line='';

  for $line (@lines) {

	logfile(" in for loop ... 1\n");

	$lineno++;
	print "+++ LINE: $line\n" if $DEBUG;
	# this is a header, increment the reocrd count by one.

	$line=~/^(\#|\?|\%|\$|\/|\&).{5}(.{3,3})/ && do {
	  # found a new header
	  ($lineno==1) && ($FOUND_HEADER=1);

	  # Increment the record count
	  $rec_count++;

	  # Save the header
	  $mechspec_header = $line;

	  print "Header CCNA: $currccna\n" if $DEBUG;
	};

	logfile(" in for loop ... 2\n");

	# If this is a new (NR or R40A or R50A) record
	$line=~/^((NR.*)|(R40A.*)|(R50A.*))/ && do {
	  # If previous line is header, 
	  #		then no need to add it again in new file
	  # Otherwise, 
	  #     Create a new record, push the header into it.

	  if (not $prev_line=~/^(\#|\?|\%|\$|\/|\&).{5}(.{3,3})/) {
		# Increment the record count
		$rec_count++;

		# Pad the record count with leading zeroes (0) to 5 digits
		$rec_count = sprintf("%05d", $rec_count);

		print "========= Pushing New Header to the New record =========\n" if $DEBUG;
		push @{$mechspec_records{"MS".$rec_count}}, $mechspec_header;
	  }
	};

	logfile(" in for loop ... 3\n");

	# If this is a new IR|YR record
	$line=~/^([IYE]R.{25}(.{16,16}))/ && do 
	  {
		# If previous line is header, 
		#		then no need to add it again in new file
		# Else 
		#		If, previous IR|YR's PON is same
		#			then no need to add it again in new file
		#		Else,
		#			Create a new record, push the header into it.
	  
		$curr_pon=$2;
		
		if (not $prev_line=~/^(\#|\?|\%|\$|\/|\&).{5}(.{3,3})/) {
		  if ($prev_line=~/^([IYE]R*)/) 
			{
			  $prev_pon= substr($prev_line, 27,16);

			  print "==== ".$prev_pon."====".$curr_pon."\n" if $DEBUG;
			  if ( (&trimwhitespace($prev_pon) ne '') && ($prev_pon ne $curr_pon)) 
				{
				  print "========== Previous PON is: ".$prev_pon."========= \n" if $DEBUG;
		  # Increment the record count
		  $rec_count++;
		  
		  # Pad the record count with leading zeroes (0) to 5 digits
		  $rec_count = sprintf("%05d", $rec_count);
		  
		  print "========= Pushing New Header to the New record =========\n" if $DEBUG;
		  push @{$mechspec_records{"MS".$rec_count}}, $mechspec_header;
				};
			}
		}
	  };  # end : IR Record check
	

	logfile(" in for loop ... 4\n");

	# Skip the KR (Trailer) record for now. 
	# It'd be auto-generated for each output file.
	$line=~/^(KR*)/ && do {
	  next;
	};

	# The *IR (Optional Request Header) record. 
	$line=~/^(\*IR*)/ && do {
	  # If previous line is header, 
	  #		then no need to add it again in new file
	  # Otherwise, 
	  #		This is the beginning of a new ack/nack record.
	  #     Create a new record, push the header into it.

	  if (not $prev_line=~/^(\#|\?|\%|\$|\/|\&).{5}(.{3,3})/) {
		# Increment the record count
		$rec_count++;

		# Pad the record count with leading zeroes (0) to 5 digits
		$rec_count = sprintf("%05d", $rec_count);

		print "========= Pushing New Header to the New record =========\n" if $DEBUG;
		push @{$mechspec_records{"MS".$rec_count}}, $mechspec_header;
	  }
	};

	logfile(" in for loop ... 5\n");

	# Default: Pad the record count with leading zeroes (0) to 5 digits
    $rec_count = sprintf("%05d", $rec_count);

	# Default: Add the line to the current mechspec records hash
	push @{$mechspec_records{"MS".$rec_count}}, $line;

	# Save this line as previous line, to avoid repeatition of header
	$prev_line = $line;

	logfile(" in for loop ... 6\n");

  }	# end: for $line (@lines)

  # Calculate the value count in Trailer record (KR) for each generated output file
  for my $record (sort(keys(%mechspec_records))) {
	$count = @{$mechspec_records{$record}};
	print "Output file with prefix <".$record."> contains <".$count."> records.\n" if $DEBUG;
	logfile("Output file with prefix <".$record."> contains <".$count."> records.\n");

	# Add 1 to accomodate the KR record line in count.
	$count++;

	# Pad the record count with leading zeroes (0) to 5 digits
	$count = sprintf("%05d", $count) ;

	# default: Push the generated trailer record
	push @{$mechspec_records{$record}}, "KR".$count;
  }

	logfile(" going to close file \n");

  # make sure you found a header, if not, move file to
  # error folder
  if ($FOUND_HEADER) {
	# print the files generated from $file
	&printfiles($file);
	# move batch file to processed dir
	$targetdir="$INBOX/processed";
  } else {
	# move batch file to error dir
	print "!!! ERROR: File: $file did not contain a header record in line #1\n";
	$targetdir="$INBOX/error";
  }

	logfile(" Moving file: $file to $targetdir ...\n");

  # move and rename the batch file
  print "... Moving file: $file to $targetdir\n";
  -d "$targetdir" || system "mkdir -p $targetdir";
  system "mv $file $targetdir";
	logfile(" Moved file: $file to $targetdir ...\n");


}								# end: for $file (@FILES)

&cleanup;

#========================================================================
# Subroutines
#========================================================================

#------------------------------------------------------------------------
sub printfiles {
  #------------------------------------------------------------------------

  my $file=&basename(shift);
  my $wholefile;

  # create files from the hash tables
  for my $record (sort(keys(%mechspec_records))) {
	my $newfile=$OUTBOX.'/'.$record.'_'.$file;
	print "... Generating file: $newfile\n";
	logfile("Printfiles : Generating file: $newfile ...\n");
	open(FILE,">$newfile") || do {
	  print "!!! ERROR: Can't create $newfile\n";
	  print "... Exiting\n";
	  &cleanup;
	};

	for $line (@{$mechspec_records{$record}}) {
	  print FILE "$line\n";
	}
	close FILE;
	logfile("Printfiles Done\n");
  }

}

#------------------------------------------------------------------------
# Remove whitespace from the start and end of the string
sub trimwhitespace($)
  #------------------------------------------------------------------------
  {
	my $string = shift;
	$string =~ s/^\s+//;
	$string =~ s/\s+$//;
	return $string;
  }

#------------------------------------------------------------------------
# log the statements into log.txt file
sub logfile($)
  #------------------------------------------------------------------------
  {
	my $str = shift;
	open(LOG,">>log.txt");
	print LOG "$str";
	close LOG;
    return true;
  }

#------------------------------------------------------------------------
sub pollfiles {
  #------------------------------------------------------------------------

  my @staticfiles;
  my $oldsize, $newsize;
  my @files=glob("$INBOX/*");

  # check for semaphore lock file
  if (-e "$INBOX/$SEMAPHORE_LOCKFILE") {
	print "!!! WARNING: a previous process is running or has left a\n";
	print "!!! WARNING: semaphore file in $INBOX:\n";
	print "!!! $INBOX/$SEMAPHORE_LOCKFILE\n";
	exit 1;
  } else {
	# create one
	system "touch $INBOX/$SEMAPHORE_LOCKFILE";
  }

  for my $file (@files) {
	# only test files that match the prefix
	&basename($file)=~/^$FILE_PREFIX/ || next;
	$oldsize=-s $file;
	print "... Polling file: $file; size=$oldsize\n";
	# sleep and check again...
	sleep $pollingsleeptime;
	$newsize=-s $file;
	print "... Polling file: $file; size=$newsize\n";
	if ($oldsize==$newsize) {
	  push @filelist, $file;
	} else {
	  print "!!! WARNING: file $file size is changing, ignoring\n";
	}
  }

  # return list of static files
  return @filelist;

}

#------------------------------------------------------------------------
sub cleanup {
  #------------------------------------------------------------------------

  # remove semaphore lock file and exit
	logfile(" insert clean up ...\n");

  -e "$INBOX/$SEMAPHORE_LOCKFILE" && unlink "$INBOX/$SEMAPHORE_LOCKFILE";
	logfile(" calling exit ...\n");
  exit 0;

}

#------------------------------------------------------------------------
sub usage {
  #------------------------------------------------------------------------

  print<<"EOF";

USAGE: $0 [options] <inbox-dir-path> <file-name-prefix>

  Option:               Description:
  -------               --------------------------------
  -h(elp)?              # prints usage
  -pollingsleeptime     # set file polling sleeptime
                        #   (default: $pollingsleeptime seconds)

e.g.:

% splitMechSpecFile.pl /export/users/ASR/inbox FOOBAR

Notes:
=====
This script takes a batched mechspec file from <inbox-dir-path> and
creates a separate file for each Record found

How it works:
============
- creates a semaphore lock file in <inbox-dir-path>: $SEMAPHORE_LOCKFILE
- read all files in <inbox-dir-path> matching <file-name-prefix>
- polls files to make sure they aren't changing, if they are they 
  are ignored for this invocation
- for each file found:
  - split into 1200 byte records
  - parse each record for header
  - build up hash of arrays for each header record
- move batch file to $INBOX/processed (create if necessary)
- for each hash of arrays:
  - create one mech spec file padded to 1200 byte lines
- remove semaphore lock file in $INBOX

EOF

  exit;
}


