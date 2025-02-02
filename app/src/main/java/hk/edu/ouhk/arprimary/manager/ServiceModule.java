package hk.edu.ouhk.arprimary.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hk.edu.ouhk.arprimary.model.LessonFragment;
import hk.edu.ouhk.arprimary.model.QuizFragment;
import hk.edu.ouhk.arprimary.model.SentenceFragment;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    public LessonFragmentManager lessonFragmentManager() {
        LessonFragmentManager fragmentManager = new LessonFragmentManager();


        // TODO add data here
        LessonFragment[] animalFragments = {
                new LessonFragment("Cow", "cow",
                        "(Noun)\nA large female farm animal kept to produce meat and milk"),
                new LessonFragment("Shark", "shark",
                        "(Noun)\nA large fish that has sharp teeth and a pointed fin on its back"),
                new LessonFragment("Wolf", "wolf",
                        "(Noun)\nA wild animal of the dog family")

        };

        LessonFragment[] fruitFragments = {
                new LessonFragment("Apple", "apple",
                        "(Noun)\nA round fruit with firm, white flesh and a green, red, or yellow skin"),
                new LessonFragment("Banana", "banana",
                        "(Noun)\nA long, curved fruit with a yellow skin and soft, sweet, white flesh inside"),
                new LessonFragment("Grape", "grape",
                        "(Noun)\nA small, round, purple or pale green fruit that you can eat or make into wine"),
                new LessonFragment("Lemon", "lemon",
                        "(Noun)\nAn oval fruit that has a thick, yellow skin and sour juice")
        };

        LessonFragment[] stationeryFragments = {
                new LessonFragment("Book", "book",
                        "(Noun)\nA written text that can be published in printed or electronic form"),
                new LessonFragment("Pencil", "pencil",
                        "(Noun)\nA long, thin object, usually made of wood, for writing or drawing, " +
                                "with a sharp black or coloured point at one end"),
                new LessonFragment("Eraser", "eraser",
                        "(Noun)\nA small piece of rubber used to remove the marks made by a pencil")
        };

        fragmentManager.registerTopicUnit("Animal", 1, animalFragments);
        fragmentManager.registerTopicUnit("Fruit", 1, fruitFragments);
        fragmentManager.registerTopicUnit("Stationery", 1, stationeryFragments);
        return fragmentManager;
    }

    @Provides
    @Singleton
    public SentenceFragmentManager sentenceFragmentManager() {

        SentenceFragmentManager sentencefragmentManager = new SentenceFragmentManager();


        SentenceFragment[] animalSentence = {
                new SentenceFragment(new ArrayList<String>(Arrays.asList("Frog", "is", "cute")), "Frog is cute"),
                new SentenceFragment(new ArrayList<String>(Arrays.asList("Farm", "has", "cow")), "Farm has cow"),
                new SentenceFragment(new ArrayList<String>(Arrays.asList("Shark", "is", "terrible")), "Shark is terrible")
        };

        SentenceFragment[] fruitSentence = {
                new SentenceFragment(new ArrayList<String>(Arrays.asList("Peter", "eats", "an","apple")), "Peter eats an apple"),
                new SentenceFragment(new ArrayList<String>(Arrays.asList("Tony", "buys", "the","banana")), "Tony buys the banana"),
                new SentenceFragment(new ArrayList<String>(Arrays.asList("Lemon", "contains", "vitamin")), "Lemon contains vitamin")
        };

        SentenceFragment[] stationerySentence = {
                new SentenceFragment(new ArrayList<String>(Arrays.asList("Mark", "reads", "the","book")), "Mark reads the book"),
                new SentenceFragment(new ArrayList<String>(Arrays.asList("Eraser", "can", "clear","the","pentrace")), "Eraser can clear the pentrace"),
                new SentenceFragment(new ArrayList<String>(Arrays.asList("Pencil", "is", "cheaper","thing")), "Pencil is cheaper thing")
        };
        sentencefragmentManager.registerTopicUnit("Animal", 2, animalSentence);
        sentencefragmentManager.registerTopicUnit("Fruit", 2, fruitSentence);
        sentencefragmentManager.registerTopicUnit("Stationery", 2, stationerySentence);
        return sentencefragmentManager;

    }

    @Provides
    @Singleton
    public QuizFragmentManager quizFragmentManager() {
        QuizFragmentManager quizFragmentManager = new QuizFragmentManager();

        //TODO add data here
        QuizFragment[] animalQuiz = {
                new QuizFragment("Cow", "cow"),
                new QuizFragment("Shark", "shark"),
                new QuizFragment("Wolf", "wolf")
        };

        QuizFragment[] fruitQuiz = {
                new QuizFragment("Apple", "apple"),
                new QuizFragment("Banana", "banana"),
                new QuizFragment("Grape", "grape")
        };

        QuizFragment[] stationeryQuiz = {
                new QuizFragment("Book", "book"),
                new QuizFragment("Pencil", "pencil"),
                new QuizFragment("Eraser", "eraser")
        };

        quizFragmentManager.registerTopicUnit("Animal", 1, animalQuiz);
        quizFragmentManager.registerTopicUnit("Fruit", 1, fruitQuiz);
        quizFragmentManager.registerTopicUnit("Stationery", 1, stationeryQuiz);
        return quizFragmentManager;
    }

}
