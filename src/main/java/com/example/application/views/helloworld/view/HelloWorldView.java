package com.example.application.views.helloworld.view;

import com.example.application.views.MainLayout;
import com.example.application.views.helloworld.controller.UserController;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@PageTitle("Hello World")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends HorizontalLayout {

    private TextField name;
    private TextField email;
    private TextField telefone;
    private Button sayHello;
    private Button deleteLastEntry;

    @Autowired
    private UserController userController;

    // Crie um Grid para armazenar e exibir os dados do usuário
    private Grid<Map<String, String>> userDataGrid = new Grid<>();

    // Esta lista irá manter os dados do usuário para adicionar no Grid
    private List<Map<String, String>> userDataList = new ArrayList<>();

    public HelloWorldView(UserController userController) {

        this.userController = userController;

        name = new TextField("Your name");
        email = new TextField("Your email");
        telefone = new TextField("Your telefone");

        // Configurar as colunas do Grid
        userDataGrid.addColumn(map -> map.get("name")).setHeader("Nome");
        userDataGrid.addColumn(map -> map.get("email")).setHeader("Email");
        userDataGrid.addColumn(map -> map.get("telefone")).setHeader("Telefone");

        sayHello = new Button("Add");
        sayHello.addClickListener(e -> {

            Notification.show("Hello " + name.getValue() + email.getValue() + telefone.getValue());
            userController.saveName(name.getValue(), email.getValue(), telefone.getValue());
            // Adicione os dados do usuário na lista e atualize o grid
            Map<String, String> userData = new HashMap<>();
            userData.put("name", name.getValue());
            userData.put("email", email.getValue());
            userData.put("telefone", telefone.getValue());
            userDataList.add(userData);
            userDataGrid.setItems(userDataList);
        });
        sayHello.addClickShortcut(Key.ENTER);
        //delete
        deleteLastEntry = new Button("Delete Last Entry");
        deleteLastEntry.addClickListener(e -> {
            if(!userDataList.isEmpty()) {
                userDataList.remove(userDataList.size() - 1);
                userDataGrid.setItems(userDataList);
                Notification.show("Last entry deleted");
            } else {
                Notification.show("No entries to delete");
            }
        });

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, email, telefone, sayHello, deleteLastEntry);

        add(name, email, telefone, sayHello,deleteLastEntry, userDataGrid);
    }

}
// ativar o banco de dados h2 -ok

// criar as entidades da classe HelloWorld -ok

// para se comunicar com o banco de dados. eu quero dizer que quando eu usar a interface da aplicação para dizer say hello
// eu preciso que o dado inserido no input seja adicionado ao banco de dados