package br.com.fiap.tds.twotdspj.javaadv.taskManager.domain.model;


public enum TaskPriority{
        LOW(1), MEDIUM(3), HIGH(5);
        
        private final int value;
        
        TaskPriority( int value){
            this.value = value;
        }
        
        public int getValue(){
            return this.value;
        }
        
        public static TaskPriority fromValue( int value ){
            for( TaskPriority priority : TaskPriority.values()){
                if( priority.getValue() == value )
                    return priority;
            }
            throw new IllegalArgumentException("Invalid priority value: " + value);
        }
    }