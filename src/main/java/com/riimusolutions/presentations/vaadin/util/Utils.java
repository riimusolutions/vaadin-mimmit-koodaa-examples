package com.riimusolutions.presentations.vaadin.util;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

import java.util.function.Consumer;

public class Utils {
    public static RadioButtonGroup<Boolean> createBooleanRadioGroup(String label, boolean initialValue, Consumer<Boolean> valueChangeAction) {
        RadioButtonGroup<Boolean> toggle = new RadioButtonGroup<>();
        toggle.setItems(Boolean.TRUE, Boolean.FALSE);
        toggle.setLabel(label);
        toggle.addValueChangeListener(event -> valueChangeAction.accept(event.getValue()));
        toggle.setValue(initialValue);
        return toggle;
    }

    public static ComboBox<FlexComponent.JustifyContentMode> createJustifyContentComboBox(Consumer<FlexComponent.JustifyContentMode> action) {
        ComboBox<FlexComponent.JustifyContentMode> justifyContent = new ComboBox<>();
        justifyContent.setLabel("Justify Content");
        justifyContent.setItems(FlexComponent.JustifyContentMode.values());
        justifyContent.addValueChangeListener(event -> action.accept(event.getValue()));
        justifyContent.setValue(FlexComponent.JustifyContentMode.START);
        return justifyContent;
    }

    public static ComboBox<Alignment> createAlignmentComboBox(Consumer<Alignment> action) {
        ComboBox<Alignment> alignment = new ComboBox<>();
        alignment.setLabel("Alignment");
        alignment.setItems(Alignment.values());
        alignment.addValueChangeListener(event -> action.accept(event.getValue()));
        alignment.setValue(Alignment.START);
        return alignment;
    }

    public static void setBorder(HasStyle element, String color) {
        element.getStyle().set("border", "1px solid " + color);
    }

    public static Div createBorderContainer() {
        Div div = new Div();
        div.setWidthFull();
        setBorder(div, "black");
        div.getStyle().set("box-sizing", "border-box");
        return div;
    }
}
