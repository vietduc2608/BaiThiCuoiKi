public class NodeHangHoa {
    public HangHoa hangHoa;
    public NodeHangHoa next;

    
    public HangHoa getHangHoa() {
        return hangHoa;
    }
    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }
    public NodeHangHoa getNext() {
        return next;
    }
    public void setNext(NodeHangHoa next) {
        this.next = next;
    }
    public NodeHangHoa(HangHoa hangHoa){
        this.hangHoa = hangHoa;
        this.next = null;
    }
    
    public boolean ID(int id){
        return this.hangHoa.getID() == id;
    }
}
