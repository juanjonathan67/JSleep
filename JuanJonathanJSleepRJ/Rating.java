package JuanJonathanJSleepRJ;

public class Rating
{
    private long total;
    private long count;

    public Rating()
    {
        this.total = 0;
        this.count = 0;
    }

    public void insert(int rating){
        this.total += rating;
        this.count++;
    }

    public double getAverage(){
        if(count == 0){
            return 0.0;
        }
        return this.total / this.count;
    }

    public long getCount(){
        return this.count;
    }

    public long getTotal(){
        return this.total;
    }

    public String toString(){
        return "Total : " + this.total + "\nCount : " + this.count;
    }
}
