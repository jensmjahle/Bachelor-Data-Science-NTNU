#include "task_2.h"
#include <gtkmm.h>

#include <iostream>

class Window : public Gtk::Window {
public:
  Gtk::Box box;
  Gtk::Entry firstname_entry;
  Gtk::Entry lastname_entry;
  Gtk::Button button;
  Gtk::Label firstname_label;
  Gtk::Label lastname_label;
  Gtk::Label result_label;

  Window() : box(Gtk::Orientation::ORIENTATION_VERTICAL) {
    set_title("Assignment 4 task 2");
    set_default_size(400, 200);
    
    firstname_label.set_text("Fornavn:");
    lastname_label.set_text("Etternavn:");
      
    firstname_entry.set_placeholder_text("Skriv inn fornavn");
    lastname_entry.set_placeholder_text("Skriv inn etternavn");  
      
    button.set_label("Slå sammen");
    button.set_sensitive(false); //button is deactivated until both entries are filled 
        
    box.pack_start(firstname_label);    
    box.pack_start(firstname_entry);
    box.pack_start(lastname_label);
    box.pack_start(lastname_entry);
    box.pack_start(button); 
    box.pack_start(result_label); 

    add(box);   // Add vbox to window
    show_all(); // Show all widgets

auto check_entries = [this]() {
     if (!firstname_entry.get_text().empty() && !lastname_entry.get_text().empty()) {
       button.set_sensitive(true);  
     } else {
       button.set_sensitive(false);  
     }
   };

   firstname_entry.signal_changed().connect(check_entries);
   lastname_entry.signal_changed().connect(check_entries);
   
   button.signal_clicked().connect([this]() {
     std::string fullname = firstname_entry.get_text() + " " + lastname_entry.get_text();
     result_label.set_text("Sammenslått navn: " + fullname);
   });
 }
};


 // task_2.cpp
void task_2(int argc, char *argv[]) {
    auto app = Gtk::Application::create(argc, argv);
    Window window;
    app->run(window);
}
