// @Deprecated – Console-only class, excluded from web build
package com.fitlogix.ui;

import com.fitlogix.dao.*;
import com.fitlogix.service.*;

@Deprecated
public class App {
    public static void main(String[] args) {
        DataStore ds = new DataStore();
        FitnessService service = new FitnessService(ds);
        ConsoleUI ui = new ConsoleUI(service, ds);
        ui.start();
    }
}
