module restricted.module {
    exports com.example.sezertanriverdi.restricted;
    opens   com.example.sezertanriverdi.restricted    to reflection.accessible.module;
}