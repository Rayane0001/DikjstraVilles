module jfc.sae.dikjstravilles {
    requires javafx.controls;
    requires javafx.fxml;


    opens jfc.sae.dikjstravilles to javafx.fxml;
    exports jfc.sae.dikjstravilles;
}