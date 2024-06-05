module jfc.sae.dikjstravilles {
    requires javafx.controls;
    requires javafx.fxml;
    requires smartgraph;


    opens jfc.sae.dikjstravilles to javafx.fxml;
    exports jfc.sae.dikjstravilles;
}