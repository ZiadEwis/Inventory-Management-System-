package DataBaseItem;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

abstract class DatabaseItem {
    public abstract String getSearchKey();
    public abstract String lineRepresentation();
}