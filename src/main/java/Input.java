import static java.lang.System.exit;

public class Input {

  static String help = """
      Please input n1, m1, n2, m2, modulus, separated by spaces.
      n1 : number of lines of the first matrix
      m1 : number of columns of the first matrix
      n2 : number of lines of the second matrix
      m2 : number of columns of the second matrix
      modulus : the two matrices' modulus
      """;

  static final int expectedSize = 5;

  static int[] parseInput(String[] args) {
    int[] parsedValues = new int[args.length];
    if (args.length == 0) {
      System.out.print(
          "\nNo input found.\n" + help
      );
      exit(1);
    }
    if (args.length != 5) {
      System.out.print(
          "\nInvalid count of values (expected " + expectedSize + ", got " + args.length + ").\n" + help
      );
      exit(1);
    }
    try {
      for (int i = 0; i < args.length; ++i) {
        parsedValues[i] = Integer.parseInt(args[i]);
      }
    } catch (NumberFormatException nfe) {
      throw new IllegalArgumentException(
          "Illegal input detected. Please input integers only."
      );
    }
    return parsedValues;
  }
}
