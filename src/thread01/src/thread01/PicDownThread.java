package thread01.src.thread01;

public class PicDownThread extends Thread {
    private String url;
    private String name;

    public PicDownThread(String url, String name) {
        this.name=name;
        this.url=url;
    }

    public static void main(String[] args) {
        PicDownThread p1=new PicDownThread("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2534506313,1688529724&fm=26&gp=0.jpg","风景.jpg");
        PicDownThread p2=new PicDownThread("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1208538952,1443328523&fm=26&gp=0.jpg","鸟.jpg"
        );
        PicDownThread p3=new PicDownThread("https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3173584241,3533290860&fm=26&gp=0.jpg","虎.jpg");

        p1.start();
        p2.start();
        p3.start();
    }
    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.download(url,name);
        System.out.println(name);
    }
}
