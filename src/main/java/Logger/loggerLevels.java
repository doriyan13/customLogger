package Logger;

public enum loggerLevels {
    INFO(0),
    DEBUG(1),
    WARNING(2),
    ERROR(3),
    SERVER_NOTICE (4),
    NOTICE (5),
    ;

    private final Integer lvl;

    loggerLevels(final Integer currLevel){
        this.lvl = currLevel;
    }
    @Override
    public String toString(){
        return this.lvl.toString();
    }
}
