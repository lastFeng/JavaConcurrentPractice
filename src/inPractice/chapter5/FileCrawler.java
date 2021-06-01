package inPractice.chapter5;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileCrawler implements Runnable{
    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;

    public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root) {
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    @Override
    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] files = root.listFiles(fileFilter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    crawl(file);
                } else if (!alreadyIndexed(file)) {
                    fileQueue.put(file);
                }
            }
        }
    }

    private boolean alreadyIndexed(File file) {
        String canonicalPath = file.getAbsolutePath() + file.getName();
        // 这里检查数据库是否已经有了这个文件
        return false;
    }

    public static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingQueue<>(265);
        FileFilter fileFilter = pathname -> true;

        for (File root : roots) {
            new Thread(new FileCrawler(queue, fileFilter, root)).start();
        }

        for (int i = 0; i < 4; i++) {
            new Thread(new Indexer(queue)).start();
        }
    }

    public static void main(String[] args) {
        File file = new File("D:\\Workspaces\\work\\JavaConcurrentPractice\\src");
        startIndexing(new File[]{file});
    }
}

class Indexer implements Runnable{
    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                indexFile(queue.take());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void indexFile(File take) {
        System.out.println(take.getAbsolutePath() +take.getName());
        System.out.println("do index file...");
        System.out.println("---------");
    }
}

