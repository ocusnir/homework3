package homework.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Exercise1 {

    static final Scanner scanner = new Scanner(System.in); //Вызываем класс сканер для ввода с консоли
    static final String start = "y" ; // Требуемый символ ввода для старта игры
    static final String exit = "n"; // Требуемый символ ввода для выхода из игры

    /**
     * Метод меню игры. Он отвечает за старт игры
     * и вызывается самым первым в главном(main) методе класса Exercise1
     */
    private static void GameMenu(){
        System.out.println("|| Пожалуйста введите символ 'y', если хотите начать игру ||\n|| или 'n', если хотите покинуть игру: ||");
        System.out.print("\nНачать игру?: ");
        String enter = scanner.nextLine();
        final boolean compare = enter.equals(start);
        final boolean compare2 = enter.equals(exit);

        if(compare) {
            GameHasStarted();
        }else if (compare2){
            ExitTheGame();
        } else {
            Error();
        }
    }

    /**
     * Метод отвечающий за начало игры, он содержит в себе условие 3-х попыток
     */
    private static void GameHasStarted() {
            Random random = new Random(); // генерация случайного числа
            final int GUESSED_NUMBER; //пустая переменная, которой мы присвоим случайное число, после чего будем с ним работать
            GUESSED_NUMBER = random.nextInt(9); // Присваиваем переменной 'GUESSED_NUMBER' случайное число

       System.out.println("\nЗагаданное число: " + GUESSED_NUMBER ); //Используйте для проверки

        System.out.print("\nИгра ОТГАДАЙ ЧИСЛО - началась!");
        System.out.print("\n================================");
        System.out.print("\nПРАВИЛА: Компьютер загадывает число от 0 до 9.\nВаша задача отгадать это число. \nБудьте осторожны, у вас есть 3 попытки");
        System.out.print("\n================================");

        for (int i = 0; i < 1; i++) {
            //Начало игры и первой попытки
            System.out.print("\n\nПервая попытка: ");
            int first_try = scanner.nextInt();

            //Победа с первой попытки
            if (first_try == GUESSED_NUMBER) {
                YouWin();
            }
            //Не угадал с первой попытки, число было больше или меньше загаданного
            if (first_try < GUESSED_NUMBER) {
                int dif = GUESSED_NUMBER - first_try;
                System.out.println("\nВы почти близко!" + "\nЗагаданное число больше вашего.");
                System.out.println("У вас осталось ещё [2] попытки!");
                System.out.println("================================");
                System.out.print("\nВторая попытка: ");
            }
            if (first_try > GUESSED_NUMBER) {
                System.out.println("\nВы почти близко!" + "\nЗагаданное число меньше вашего.");
                System.out.println("У вас осталось ещё [2] попытки!");
                System.out.println("================================");
                System.out.print("\nВторая попытка: ");
                }
            //Начало второй попытки
            int second_try = scanner.nextInt();

            //Победа со второй попытки
            if (second_try == GUESSED_NUMBER) {
                YouWin();
            }
            //Проверка на повтор числа
            if (second_try < GUESSED_NUMBER && second_try == first_try) {
                System.out.println("\nВы уже вводили это число!" + "\nЧисла нельзя вводить повторно!");
                System.out.println("У вас осталось ещё [1] попытка!");
                System.out.println("================================");
                System.out.print("\nТретья попытка: ");

            }
            //Не угадал со второй попытки, число было больше или меньше загаданного
            if (second_try < GUESSED_NUMBER && second_try != first_try) {
                System.out.println("\nВы почти близко!" + "\nЗагаданное число больше вашего.");
                System.out.println("У вас осталось ещё [1] попытка!");
                System.out.println("================================");
                System.out.print("\nТретья попытка: ");
            }
            if (second_try > GUESSED_NUMBER && second_try == first_try) {
                System.out.println("\nВы уже вводили это число!" + "\nЧисла нельзя вводить повторно!");
                System.out.println("У вас осталось ещё [1] попытка!");
                System.out.println("================================");
                System.out.print("\nТретья попытка: ");
            }
            if (second_try > GUESSED_NUMBER && second_try != first_try){
                System.out.println("\nВы почти близко!" + "\nЗагаданное число меньше вашего.");
                System.out.println("У вас осталось ещё [1] попытка!");
                System.out.println("================================");
                System.out.print("\nТретья попытка: ");

            }

            //Начало Третьей попытки
            int last_try = scanner.nextInt();

            //Победа с третьей попытки
            if (last_try == GUESSED_NUMBER){
                YouWin();
            }
            //Не угадал с третьей попытки, число было больше или
            //меньше загаданного, исчерпал все попытки и проиграл
            if (last_try < GUESSED_NUMBER) {
                System.out.print("\nGAME OVER!");
                System.out.print("\nЗагаданное число было : " + GUESSED_NUMBER );
               GameOver();

            }
            if (last_try > GUESSED_NUMBER){
                System.out.print("\nGAME OVER!");
                System.out.print("\nЗагаданное число было : " + GUESSED_NUMBER );
                GameOver();
            }
        }
    }

    /**
     * Метод победы.
     * Выводит на экран сообщение о победе, а также предлагает повторить или завершить игру
     */
    public static void YouWin(){

        System.out.print("\nВЫ УГАДАЛИ ЧИСЛО!");
        System.out.print("\nХотите повторить игру?: y - yes | n - no: ");
        scanner.nextLine();
        String sc = scanner.nextLine();
        final boolean r = sc.equals(start);
        final boolean e = sc.equals(exit);

        if(r){
            GameHasStarted();
        }else if(e){
            ExitTheGame();
        }else {
            Error();
        }
    }

    /**
     * Метод проигрыша.
     * Выводит на экран сообщение о проигрыше, а также предлагает повторить или завершить игру
     */
    public static void GameOver(){

        System.out.print("\n================================");
        System.out.print("\nВы исчерпали все попытки.. ");
        System.out.print("\nХотите повторить игру?: y - yes | n - no ");
        scanner.nextLine();
        String enter = scanner.nextLine();
        final boolean r = enter.equals(start);
        final boolean e = enter.equals(exit);

        if(r){
            GameHasStarted();
        }else if(e){
            ExitTheGame();
        }else {
            Error();
        }
    }

    /**
     * Метод вызывается в случае ошибки ввода строки
     */
    public static void Error(){

        //Цикл выводит ошибку до тех пор, пока игрок(пользователь),
        //будет вводить любые символы, включая пустой ввод, вместо 'y' или 'n',
        while (true){

            System.out.print("\nОШИБКА ВВОДА: Пожалуйста введите символ 'y', если хотите начать игру, или  символ 'n', если хотите выйти из игры: ");
            System.out.print("\ny / n : ");
            String enter = scanner.nextLine();
            final boolean error_compare = enter.equals(start);
            final boolean error_compare2 = enter.equals(exit);

            if(error_compare){
                GameHasStarted();
            } else if(error_compare2) {
                ExitTheGame();
            }else {
                Error();
            }
            break;
        }

    }
    /**
     * Метод вызывается в случае если игрок не захочет играть в игру
     * или продолжать игру после победы или проигрыша
     */
    public static void ExitTheGame(){
            System.out.println("Скоро Увидимся!");

        }

    public static void main(String[] args) {
        GameMenu();

        }
    }