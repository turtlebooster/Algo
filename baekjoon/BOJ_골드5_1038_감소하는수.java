package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_1038_감소하는수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		
		long[] arr = {0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 20L, 21L, 30L, 31L, 32L, 40L, 41L, 42L, 43L, 50L, 51L, 52L, 53L, 54L, 60L, 61L, 62L, 63L, 64L, 65L, 70L, 71L, 72L, 73L, 74L, 75L, 76L, 80L, 81L, 82L, 83L, 84L, 85L, 86L, 87L, 90L, 91L, 92L, 93L, 94L, 95L, 96L, 97L, 98L, 210L, 310L, 320L, 321L, 410L, 420L, 421L, 430L, 431L, 432L, 510L, 520L, 521L, 530L, 531L, 532L, 540L, 541L, 542L, 543L, 610L, 620L, 621L, 630L, 631L, 632L, 640L, 641L, 642L, 643L, 650L, 651L, 652L, 653L, 654L, 710L, 720L, 721L, 730L, 731L, 732L, 740L, 741L, 742L, 743L, 750L, 751L, 752L, 753L, 754L, 760L, 761L, 762L, 763L, 764L, 765L, 810L, 820L, 821L, 830L, 831L, 832L, 840L, 841L, 842L, 843L, 850L, 851L, 852L, 853L, 854L, 860L, 861L, 862L, 863L, 864L, 865L, 870L, 871L, 872L, 873L, 874L, 875L, 876L, 910L, 920L, 921L, 930L, 931L, 932L, 940L, 941L, 942L, 943L, 950L, 951L, 952L, 953L, 954L, 960L, 961L, 962L, 963L, 964L, 965L, 970L, 971L, 972L, 973L, 974L, 975L, 976L, 980L, 981L, 982L, 983L, 984L, 985L, 986L, 987L, 3210L, 4210L, 4310L, 4320L, 4321L, 5210L, 5310L, 5320L, 5321L, 5410L, 5420L, 5421L, 5430L, 5431L, 5432L, 6210L, 6310L, 6320L, 6321L, 6410L, 6420L, 6421L, 6430L, 6431L, 6432L, 6510L, 6520L, 6521L, 6530L, 6531L, 6532L, 6540L, 6541L, 6542L, 6543L, 7210L, 7310L, 7320L, 7321L, 7410L, 7420L, 7421L, 7430L, 7431L, 7432L, 7510L, 7520L, 7521L, 7530L, 7531L, 7532L, 7540L, 7541L, 7542L, 7543L, 7610L, 7620L, 7621L, 7630L, 7631L, 7632L, 7640L, 7641L, 7642L, 7643L, 7650L, 7651L, 7652L, 7653L, 7654L, 8210L, 8310L, 8320L, 8321L, 8410L, 8420L, 8421L, 8430L, 8431L, 8432L, 8510L, 8520L, 8521L, 8530L, 8531L, 8532L, 8540L, 8541L, 8542L, 8543L, 8610L, 8620L, 8621L, 8630L, 8631L, 8632L, 8640L, 8641L, 8642L, 8643L, 8650L, 8651L, 8652L, 8653L, 8654L, 8710L, 8720L, 8721L, 8730L, 8731L, 8732L, 8740L, 8741L, 8742L, 8743L, 8750L, 8751L, 8752L, 8753L, 8754L, 8760L, 8761L, 8762L, 8763L, 8764L, 8765L, 9210L, 9310L, 9320L, 9321L, 9410L, 9420L, 9421L, 9430L, 9431L, 9432L, 9510L, 9520L, 9521L, 9530L, 9531L, 9532L, 9540L, 9541L, 9542L, 9543L, 9610L, 9620L, 9621L, 9630L, 9631L, 9632L, 9640L, 9641L, 9642L, 9643L, 9650L, 9651L, 9652L, 9653L, 9654L, 9710L, 9720L, 9721L, 9730L, 9731L, 9732L, 9740L, 9741L, 9742L, 9743L, 9750L, 9751L, 9752L, 9753L, 9754L, 9760L, 9761L, 9762L, 9763L, 9764L, 9765L, 9810L, 9820L, 9821L, 9830L, 9831L, 9832L, 9840L, 9841L, 9842L, 9843L, 9850L, 9851L, 9852L, 9853L, 9854L, 9860L, 9861L, 9862L, 9863L, 9864L, 9865L, 9870L, 9871L, 9872L, 9873L, 9874L, 9875L, 9876L, 43210L, 53210L, 54210L, 54310L, 54320L, 54321L, 63210L, 64210L, 64310L, 64320L, 64321L, 65210L, 65310L, 65320L, 65321L, 65410L, 65420L, 65421L, 65430L, 65431L, 65432L, 73210L, 74210L, 74310L, 74320L, 74321L, 75210L, 75310L, 75320L, 75321L, 75410L, 75420L, 75421L, 75430L, 75431L, 75432L, 76210L, 76310L, 76320L, 76321L, 76410L, 76420L, 76421L, 76430L, 76431L, 76432L, 76510L, 76520L, 76521L, 76530L, 76531L, 76532L, 76540L, 76541L, 76542L, 76543L, 83210L, 84210L, 84310L, 84320L, 84321L, 85210L, 85310L, 85320L, 85321L, 85410L, 85420L, 85421L, 85430L, 85431L, 85432L, 86210L, 86310L, 86320L, 86321L, 86410L, 86420L, 86421L, 86430L, 86431L, 86432L, 86510L, 86520L, 86521L, 86530L, 86531L, 86532L, 86540L, 86541L, 86542L, 86543L, 87210L, 87310L, 87320L, 87321L, 87410L, 87420L, 87421L, 87430L, 87431L, 87432L, 87510L, 87520L, 87521L, 87530L, 87531L, 87532L, 87540L, 87541L, 87542L, 87543L, 87610L, 87620L, 87621L, 87630L, 87631L, 87632L, 87640L, 87641L, 87642L, 87643L, 87650L, 87651L, 87652L, 87653L, 87654L, 93210L, 94210L, 94310L, 94320L, 94321L, 95210L, 95310L, 95320L, 95321L, 95410L, 95420L, 95421L, 95430L, 95431L, 95432L, 96210L, 96310L, 96320L, 96321L, 96410L, 96420L, 96421L, 96430L, 96431L, 96432L, 96510L, 96520L, 96521L, 96530L, 96531L, 96532L, 96540L, 96541L, 96542L, 96543L, 97210L, 97310L, 97320L, 97321L, 97410L, 97420L, 97421L, 97430L, 97431L, 97432L, 97510L, 97520L, 97521L, 97530L, 97531L, 97532L, 97540L, 97541L, 97542L, 97543L, 97610L, 97620L, 97621L, 97630L, 97631L, 97632L, 97640L, 97641L, 97642L, 97643L, 97650L, 97651L, 97652L, 97653L, 97654L, 98210L, 98310L, 98320L, 98321L, 98410L, 98420L, 98421L, 98430L, 98431L, 98432L, 98510L, 98520L, 98521L, 98530L, 98531L, 98532L, 98540L, 98541L, 98542L, 98543L, 98610L, 98620L, 98621L, 98630L, 98631L, 98632L, 98640L, 98641L, 98642L, 98643L, 98650L, 98651L, 98652L, 98653L, 98654L, 98710L, 98720L, 98721L, 98730L, 98731L, 98732L, 98740L, 98741L, 98742L, 98743L, 98750L, 98751L, 98752L, 98753L, 98754L, 98760L, 98761L, 98762L, 98763L, 98764L, 98765L, 543210L, 643210L, 653210L, 654210L, 654310L, 654320L, 654321L, 743210L, 753210L, 754210L, 754310L, 754320L, 754321L, 763210L, 764210L, 764310L, 764320L, 764321L, 765210L, 765310L, 765320L, 765321L, 765410L, 765420L, 765421L, 765430L, 765431L, 765432L, 843210L, 853210L, 854210L, 854310L, 854320L, 854321L, 863210L, 864210L, 864310L, 864320L, 864321L, 865210L, 865310L, 865320L, 865321L, 865410L, 865420L, 865421L, 865430L, 865431L, 865432L, 873210L, 874210L, 874310L, 874320L, 874321L, 875210L, 875310L, 875320L, 875321L, 875410L, 875420L, 875421L, 875430L, 875431L, 875432L, 876210L, 876310L, 876320L, 876321L, 876410L, 876420L, 876421L, 876430L, 876431L, 876432L, 876510L, 876520L, 876521L, 876530L, 876531L, 876532L, 876540L, 876541L, 876542L, 876543L, 943210L, 953210L, 954210L, 954310L, 954320L, 954321L, 963210L, 964210L, 964310L, 964320L, 964321L, 965210L, 965310L, 965320L, 965321L, 965410L, 965420L, 965421L, 965430L, 965431L, 965432L, 973210L, 974210L, 974310L, 974320L, 974321L, 975210L, 975310L, 975320L, 975321L, 975410L, 975420L, 975421L, 975430L, 975431L, 975432L, 976210L, 976310L, 976320L, 976321L, 976410L, 976420L, 976421L, 976430L, 976431L, 976432L, 976510L, 976520L, 976521L, 976530L, 976531L, 976532L, 976540L, 976541L, 976542L, 976543L, 983210L, 984210L, 984310L, 984320L, 984321L, 985210L, 985310L, 985320L, 985321L, 985410L, 985420L, 985421L, 985430L, 985431L, 985432L, 986210L, 986310L, 986320L, 986321L, 986410L, 986420L, 986421L, 986430L, 986431L, 986432L, 986510L, 986520L, 986521L, 986530L, 986531L, 986532L, 986540L, 986541L, 986542L, 986543L, 987210L, 987310L, 987320L, 987321L, 987410L, 987420L, 987421L, 987430L, 987431L, 987432L, 987510L, 987520L, 987521L, 987530L, 987531L, 987532L, 987540L, 987541L, 987542L, 987543L, 987610L, 987620L, 987621L, 987630L, 987631L, 987632L, 987640L, 987641L, 987642L, 987643L, 987650L, 987651L, 987652L, 987653L, 987654L, 6543210L, 7543210L, 7643210L, 7653210L, 7654210L, 7654310L, 7654320L, 7654321L, 8543210L, 8643210L, 8653210L, 8654210L, 8654310L, 8654320L, 8654321L, 8743210L, 8753210L, 8754210L, 8754310L, 8754320L, 8754321L, 8763210L, 8764210L, 8764310L, 8764320L, 8764321L, 8765210L, 8765310L, 8765320L, 8765321L, 8765410L, 8765420L, 8765421L, 8765430L, 8765431L, 8765432L, 9543210L, 9643210L, 9653210L, 9654210L, 9654310L, 9654320L, 9654321L, 9743210L, 9753210L, 9754210L, 9754310L, 9754320L, 9754321L, 9763210L, 9764210L, 9764310L, 9764320L, 9764321L, 9765210L, 9765310L, 9765320L, 9765321L, 9765410L, 9765420L, 9765421L, 9765430L, 9765431L, 9765432L, 9843210L, 9853210L, 9854210L, 9854310L, 9854320L, 9854321L, 9863210L, 9864210L, 9864310L, 9864320L, 9864321L, 9865210L, 9865310L, 9865320L, 9865321L, 9865410L, 9865420L, 9865421L, 9865430L, 9865431L, 9865432L, 9873210L, 9874210L, 9874310L, 9874320L, 9874321L, 9875210L, 9875310L, 9875320L, 9875321L, 9875410L, 9875420L, 9875421L, 9875430L, 9875431L, 9875432L, 9876210L, 9876310L, 9876320L, 9876321L, 9876410L, 9876420L, 9876421L, 9876430L, 9876431L, 9876432L, 9876510L, 9876520L, 9876521L, 9876530L, 9876531L, 9876532L, 9876540L, 9876541L, 9876542L, 9876543L, 76543210L, 86543210L, 87543210L, 87643210L, 87653210L, 87654210L, 87654310L, 87654320L, 87654321L, 96543210L, 97543210L, 97643210L, 97653210L, 97654210L, 97654310L, 97654320L, 97654321L, 98543210L, 98643210L, 98653210L, 98654210L, 98654310L, 98654320L, 98654321L, 98743210L, 98753210L, 98754210L, 98754310L, 98754320L, 98754321L, 98763210L, 98764210L, 98764310L, 98764320L, 98764321L, 98765210L, 98765310L, 98765320L, 98765321L, 98765410L, 98765420L, 98765421L, 98765430L, 98765431L, 98765432L, 876543210L, 976543210L, 986543210L, 987543210L, 987643210L, 987653210L, 987654210L, 987654310L, 987654320L, 987654321L, 9876543210L};
		
		if (N <= 1022) System.out.println(arr[N]);
		else System.out.println(-1);
	}
}
