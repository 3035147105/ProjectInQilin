package com.qilin.cms.designmodel.Composite;

/**
 * Created by gaohaiqing on 16-8-30.
 *
 * 组合模式
 */
public class CompositeClient {

    public static void main(String[] args){
        CompositeClient client = new CompositeClient();
        client.abstractRoot();
    }

    public void abstractRoot(){
        AbstractComposite composite = new Folder("我的收藏");

        AbstractComposite music = new Folder("音乐");
        AbstractComposite file = new File("谁明浪子心.mp3");
        AbstractComposite file2 = new File("不浪漫罪名.mp3");
        composite.addFile(music);
        music.addFile(file);
        music.addFile(file2);

        AbstractComposite video = new Folder("电影");
        AbstractComposite file3 = new File("热血高校.avi");
        composite.addFile(video);
        video.addFile(file3);

        composite.kill();
    }

    public void interfaceRoot(){
        //使用接口实现
        Folder folder = new Folder("我的收藏");

        Folder music = new Folder("音乐");
        File file = new File("不想听爱情故事.mp3");
        File file1 = new File("你说.mp3");

        Folder video = new Folder("视频");
        File file2 = new File("杀破狼.avi");

        folder.addFile(music);
        folder.addFile(video);
        music.addFile(file);
        music.addFile(file1);
        video.addFile(file2);

        folder.kill();
    }
}
