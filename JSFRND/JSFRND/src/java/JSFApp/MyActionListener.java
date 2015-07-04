/*
 * MyActionListener.java
 *
 * Created on February 28, 2006, 12:48 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package jsfApp;
import java.util.Iterator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.PhaseId;
//import javax.faces.tree.Tree;

public class MyActionListener implements ActionListener {

    public PhaseId getPhaseId() {
        System.out.println("getPhaseId called");
        return PhaseId.APPLY_REQUEST_VALUES;
    }
  
    public void processAction(ActionEvent event) {
        System.out.println("processAction called");

        // the component that triggered the action event
        UIComponent component = event.getComponent();
        System.out.println("The id of the component that fired the action event: "
            + component.getClientId());

        // the action command
        String actionCommand = event.getActionCommand();
        System.out.println("Action command: " + actionCommand);
  
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Tree tree                 = facesContext.getTree();
        UIComponent root          = tree.getRoot();

        System.out.println("----------- Component Tree -------------");
        navigateComponentTree(root, 0);
        System.out.println("----------------------------------------");
    }
  
    private void navigateComponentTree(UIComponent component, int level) {
        Iterator children = component.getChildren();

        // indent
        for (int i=0; i<level; i++)
            System.out.print("  ");

        // print component id
        System.out.println(component.getClientId());

        // navigate children
        while (children.hasNext()) {
            UIComponent child = (UIComponent) children.next();
            navigateComponentTree(child, level + 1);
        }
    }
}



