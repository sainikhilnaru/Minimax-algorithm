import java.util.ArrayList;
import java.util.List;

public class Node {
    public int value;
    public Node parent;;
    public List<Node> children = new ArrayList<Node>();
    public int depth;
    public String Location;

    public Node(){
        value = -1;
        parent=null;
        depth=0;
        Location="";
    }

    public Node(int p, Node Par, int dept ){
        setNodeValue(p);
        parent=Par;
        depth=dept+1;
        Location="";
    }
    public void setNodeValue(int p){
        value=p;
    }
    public void addChild(Node child){
        this.children.add(child);
    }
    public int  getDepth(){
        return depth;
    }
    public void min(){
        int location=1;
        int min =children.get(0).value;
        for(int i=0; i<children.size(); i++){
            if(children.get(i).value<min){
                min=children.get(i).value;
                location=i+1;
            }
        }
        if(!children.get(location-1).Location.equals("")) {
            Location += location + ", " + children.get(location - 1).Location;
        }else{
            Location += location;
        }
        this.value=min;
    }
    public void max(){
        int location=1;
        int max =children.get(0).value;
        for(int i=0; i<children.size(); i++){
            if(children.get(i).value>max){
                max=children.get(i).value;
                location=i+1;
            }
        }
        if(!children.get(location-1).Location.equals("")) {
            Location += location + ", " + children.get(location - 1).Location;
        }else{
            Location += location;
        }
        this.value=max;
    }

}
