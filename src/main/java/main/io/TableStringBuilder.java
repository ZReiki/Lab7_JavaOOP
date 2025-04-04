package main.io;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class TableStringBuilder<T> {
    private final List<String> columnNames;
    private final List<Function<? super T, String>> stringFunctions;

    TableStringBuilder() {
        columnNames = new ArrayList<>();
        stringFunctions = new ArrayList<>();
    }

    void addColumn(String columnName, Function<? super T, ?> fieldFunction) {
        columnNames.add(columnName);
        stringFunctions.add((p) -> (String.valueOf(fieldFunction.apply(p))));
    }

    private int computeMaxWidth(int column, Iterable<? extends T> elements) {
        int n = columnNames.get(column).length();
        Function<? super T, String> f = stringFunctions.get(column);
        for (T element : elements) {
            String s = f.apply(element);
            n = Math.max(n, s.length());
        }
        return n;
    }

    private static String padLeft(String s, char c, int length) {
        while (s.length() < length) {
            s = c + s;
        }
        return s;
    }

    private List<Integer> computeColumnWidths(Iterable<? extends T> elements) {
        List<Integer> columnWidths = new ArrayList<>();
        for (int c=0; c<columnNames.size(); c++) {
            int maxWidth = computeMaxWidth(c, elements);
            columnWidths.add(maxWidth);
        }
        return columnWidths;
    }

    private String createBorders(List<Integer> columnWidths) {
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < columnNames.size(); c++) {
            if (c > 0) {
                sb.append("+");
            }
            sb.append(padLeft("", '-', columnWidths.get(c)));
        }
        return sb.toString();
    }

    public String createString(Iterable<? extends T> elements) {
        List<Integer> columnWidths = computeColumnWidths(elements);

        StringBuilder sb = new StringBuilder();

        sb.append(createBorders(columnWidths));
        sb.append("+\n");

        for (int c = 0; c < columnNames.size(); c++) {
            if (c > 0) {
                sb.append("|");
            }
            String format = "%" + columnWidths.get(c) + "s";
            sb.append(String.format(format, columnNames.get(c)));
        }

        sb.append("|\n");
        sb.append(createBorders(columnWidths));
        sb.append("+\n");

        for (T element : elements) {
            for (int c = 0; c < columnNames.size(); c++) {
                if (c > 0) {
                    sb.append("|");
                }
                String format = "%"+columnWidths.get(c)+"s";
                Function<? super T, String> f = stringFunctions.get(c);
                String s = f.apply(element);
                sb.append(String.format(format, s));
            }
            sb.append("|\n");
        }

        sb.append(createBorders(columnWidths));
        sb.append("+\n");

        return sb.toString();
    }
}