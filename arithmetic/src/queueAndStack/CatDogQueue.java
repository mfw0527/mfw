package queueAndStack;

import java.util.LinkedList;
import java.util.Queue;

/*
猫狗队列 【题目】 宠物、狗和猫的类如下：
public class Pet { private String type;
public Pet(String type) { this.type = type; }
public String getPetType() { return this.type; }
}
public class Dog extends Pet { public Dog() { super("dog"); } }
public class Cat extends Pet { public Cat() { super("cat"); } }
实现一种狗猫队列的结构，要求如下： 用户可以调用add方法将cat类或dog类的
实例放入队列中； 用户可以调用pollAll方法，将队列中所有的实例按照进队列
的先后顺序依次弹出； 用户可以调用pollDog方法，将队列中dog类的实例按照
进队列的先后顺序依次弹出； 用户可以调用pollCat方法，将队列中cat类的实
例按照进队列的先后顺序依次弹出； 用户可以调用isEmpty方法，检查队列中是
否还有dog或cat的实例； 用户可以调用isDogEmpty方法，检查队列中是否有dog
类的实例； 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 */
public class CatDogQueue {
    public static class Pet {
        private String type;
        public Pet(String type) {
            this.type = type;
        }
        public String getPetType() {
            return this.type;
        }
    }
    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }
    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }
    //辅助类，用来帮助 记录宠物进入先后顺序 的类
    public static class EnterDogOrCat{
        private Pet pet;
        private long count;
        public EnterDogOrCat(Pet pet,long count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String enterPetType(){
            return this.getPet().getPetType();
        }
    }

    public static class DogCatQueue{
        //狗队列
        Queue<EnterDogOrCat> catQueue;
        //猫队列
        Queue<EnterDogOrCat> dogQueue;
        //记录进入顺序
        long count ;
        public DogCatQueue(){
            catQueue = new LinkedList<>();
            dogQueue = new LinkedList<>();
            count = 0;
        }
        /*
            用户可以调用add方法将cat类或dog类的实例放入队列中；
         */
        public void add(Pet pet){
            if(pet.getPetType().equals("dog")){
                dogQueue.add(new EnterDogOrCat(pet,this.count++));
            }else if(pet.getPetType().equals("cat")){
                catQueue.add(new EnterDogOrCat(pet,this.count++));
            }else {
                throw new RuntimeException("error,not dog or cat.");
            }
        }
        /*
            用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出
         */
        public Pet pollAll() {
            if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
                if (this.catQueue.peek().getCount() < this.dogQueue.peek().getCount()) {
                    return this.catQueue.poll().getPet();
                } else {
                    return this.dogQueue.poll().getPet();
                }
            }else if (!this.dogQueue.isEmpty()){
                return this.dogQueue.poll().getPet();
            }else if (!this.catQueue.isEmpty()){
                return this.catQueue.poll().getPet();
            }else {
                throw new RuntimeException("error,queue is empty.");
            }
        }
        /*
            用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出
         */
        public Pet pollDog(){
            if (this.dogQueue.isEmpty()) {//this.isDogEmpty()
                throw new RuntimeException("error,dog queue is empty.");
            }else {
                return (Dog)this.dogQueue.poll().getPet();
            }
        }
        /*
            用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出
         */
        public Pet pollCat(){
            if (this.catQueue.isEmpty()) {//this.isCatEmpty()
                throw new RuntimeException("error,cat queue is empty.");
            }else {
                return (Cat)this.catQueue.poll().getPet();
            }
        }
        /*
            用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
         */
        public boolean isEmpty(){
            return this.catQueue.isEmpty() && this.dogQueue.isEmpty();
        }
        /*
            用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
         */
        public boolean isDogEmpty(){
            return this.dogQueue.isEmpty();
        }
        /*
            用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
         */
        public boolean isCatEmpty(){
            return this.catQueue.isEmpty();
        }
    }


    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}
