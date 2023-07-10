/*
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
их необходимо считать, как одного человека с разными телефонами. 
Вывод должен быть отсортирован по убыванию числа телефонов.
 */

 import java.util.*;

 public class HW005 {
    static void sortedPrint(Map<String, ArrayList> map) {
        Set<String> keySet = map.keySet();
        int maxCount = 0;
        int minCount = 1_000_000;      
        for (var item : map.entrySet()) {
            if (maxCount < item.getValue().size())
                maxCount = item.getValue().size();
            if (minCount > item.getValue().size())
                minCount = item.getValue().size(); 
 }

  Stack<String> st = new Stack<>();
        int num = minCount;
        while (num <= maxCount) {
            for (var item : map.entrySet()) {
                if (item.getValue().size() == num) {
                    st.push(item.getKey());
                }  
            }
            num += 1;
        }

        String name;
        for (int i = 0; i < keySet.size(); i++) {
            name = st.pop();
            for (var item : map.entrySet()) {
                if (name == item.getKey()) {
                    System.out.printf("%8s: ", item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        Map<String, ArrayList> abon = new HashMap<>() {
            {
                put("Володин", new ArrayList<Integer>() {
                    {
                        add(96523);
                        add(822174);
                        add(909089);
                    }
                });
                put("Сорокин", new ArrayList<Integer>() {
                    {
                        add(896336);
                    }
                });
                put("Варламов", new ArrayList<Integer>() {
                    {
                        add(776655);
                        add(982822);

                    }
                });
                put("Бобровский", new ArrayList<Integer>() {
                    {
                        add(8903309);
                        add(891234);
                        add(875689);
                        add(865498);
                    }
                });
            }
        };
        System.out.println();
        System.out.println("Исходные данные: ");
        sortedPrint(abon);
        Scanner scan = new Scanner(System.in, "cp866");
        Boolean getOut = false;
        String st;
        while (!getOut) {
            System.out.println("Введите номер операции (1 - добавить абонента, 9 - выход):");
            st = scan.nextLine();
            String name = "";
            String phString;
            switch (st) {
                case "1": {
                    System.out.println("Введите фамилию абонента:");
                    name = scan.nextLine();
                    if (abon.containsKey(name)) {
                        System.out.println("Неверный ввод!!!Такая фамилия уже есть");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Введите номера телефонов через запятую: ");
                        phString = scan.nextLine();
                        String[] arr = phString.split(",");
                        ArrayList<Integer> arrInt = new ArrayList<>();
                        for (String item: arr) {
                            arrInt.add(Integer.parseInt(item.trim())) ;
                        }
                        abon.put(name, arrInt);
                        System.out.println();
                        sortedPrint(abon);
                        break;
                    }
                }
                case "9": {
                    getOut = true;
                    System.out.println();
                    System.out.println("До свидания!!!");
                    System.out.println();
                    break;
                }                                      
            }
        }
    }
}
