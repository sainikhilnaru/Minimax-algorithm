import com.sun.xml.internal.ws.util.StringUtils;
import java.util.regex.*;
public class main {
        public static void main (String[] args) {
            Trees t = new Trees();
            String tree=t.case3;
            Node currentNode = new Node();
            String treeRootParsed =tree.substring(1);
            boolean negative=false;
            System.out.print("(");
            //add root to tree

            for(int i=0; i<tree.length()-1;i++) {
                String parsedElement = treeRootParsed.substring(i, i+1);

                if(parsedElement.equals("(") ){
                    Node newNode= new Node(-1, currentNode, currentNode.getDepth());
                    currentNode.addChild(newNode);
                    currentNode=newNode;
                    System.out.print(parsedElement);
                }else if(parsedElement.matches("^[0-9]*$")){
                    //create a child and add a value
                    int number=Integer.parseInt(parsedElement);
                    if(negative){
                        number*=-1;
                        negative=false;
                    }
                    Node newNode=new Node(number, currentNode, currentNode.getDepth());
                    currentNode.addChild(newNode);
                    System.out.print(number);
                }
                else if(parsedElement.equals(")")){
                    if(currentNode.getDepth()%2==0){
                        //apply max function
                        currentNode.max();

                    }else{
                        //apply min function at odd depth
                        currentNode.min();

                    }
                    System.out.print(")");
                    if(currentNode.parent!=null) {
                        currentNode = currentNode.parent;
                    }
                }
                else if(parsedElement.equals("-")){
                    negative=true;
                }
            }
            System.out.println();
            System.out.println("The Minimax sol is "+currentNode.value);
            System.out.println("The solution path: "+currentNode.Location);

        }


}
