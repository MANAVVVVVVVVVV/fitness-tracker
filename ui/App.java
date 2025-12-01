package com.fitlogix;

import com.fitlogix.dao.*;
import com.fitlogix.service.*;
import com.fitlogix.ui.*;

public class App {
    public static void main(String[] args) {
        DataStore ds = new DataStore();
        FitnessService service = new FitnessService(ds);
        ConsoleUI ui = new ConsoleUI(service, ds);
        ui.start();
    }
}
