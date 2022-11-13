public class funcs {
    public String nearestChapter(Chapter[] chArr, int current){
        Chapter minChap = new Chapter("First", 0);
        for(Chapter ch :chArr){
            if(abs(ch.page - current)  < abs(minChap.page - current)){
                minChap = ch;
            }
        }
        return  minChap.name;
    }

    public int abs(int num){
        if(num < 0){
            return num*-1;
        }
        return num;
    }
}
