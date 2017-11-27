/**
 * Created by avsrivathsan on 5/31/2017.
 */
public class LazyHolder {

    private static class LazyHolderInstance {
        private static LazyHolder instance = new LazyHolder();

    }

    public LazyHolder getInstance() {
        return LazyHolderInstance.instance;
    }
}
