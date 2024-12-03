public abstract class Template {

    protected abstract void readFile();

    protected abstract String solvePart1();

    protected abstract String solvePart2(); 

    protected void restructureForPart2(){}
    
    public void solve(){
        readFile();
        System.out.println(solvePart1());
        restructureForPart2();
        System.out.println(solvePart2());
    }
}
