@org.hibernate.annotations.GenericGenerator(name = "ID_GENERATOR", strategy = "enhanced-sequence", parameters = {
        @org.hibernate.annotations.Parameter(name = "sequence_name", value = "JPWHSD_SEQUENCE"),
        @org.hibernate.annotations.Parameter(name = "initial_value", value = "1000")
})
package com.manning.javapersistence.ch05;


/*
Если требуются высокая переносимость и доступность 
значений идентификаторов перед выполнением INSERT, следует использовать 
enhanced-sequence, как показано в предыдущем разделе. Это переносимая, гибкая 
и современная стратегия, предоставляющая также различные оптимизации для 
больших наборов данных.
*/