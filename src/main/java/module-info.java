module jfc.sae.dikjstravilles {
    requires javafx.controls;
    requires javafx.fxml;
    requires smartgraph;
    exports etudiant;


    opens jfc.sae.dikjstravilles to javafx.fxml;
    exports jfc.sae.dikjstravilles;
}