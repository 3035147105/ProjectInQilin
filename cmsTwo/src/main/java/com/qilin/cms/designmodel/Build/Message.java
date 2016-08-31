package com.qilin.cms.designmodel.Build;

/**
 * Created by gaohaiqing on 16-8-30.
 */
public class Message {
    private  String title;
    private String description;

    /**
     *
     * @param builder
     */
    protected Message(Message.Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
    }

    /**
     *
     * @param iosBuilder
     */
    protected Message(Message.IOSBuilder iosBuilder){
        this.title = null;
        this.description = iosBuilder.description;
    }

    /**
     * 一般消息的建造者
     */
    public static class Builder{
        private String title;
        private String description;

        public Builder() {
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }

        /**
         * 最后返回 建造好的对象
         * @return
         */
        public Message build(){
            return new Message(this);
        }
    }

    /**
     * ios消息的建造者
     */
    public static class IOSBuilder{
        private String description;
        public IOSBuilder(){
        }

        public IOSBuilder description(String description){
            this.description = description;
            return this;
        }

        public Message build(){
            return new Message(this);
        }
    }

    public String toString(){
        return "title:"+this.title+" ,description:"+this.description;
    }
}
