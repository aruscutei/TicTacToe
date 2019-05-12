public enum Symbol {
    SYMBOL_X{
        @Override
        public String toString(){
            return "x";
        }
    },
    SYMBOL_0{
        @Override
        public String toString(){
            return"0";
        }

    },
    SYMBOL_EMPTY{
        @Override
        public String toString(){
            return "-";
        }
    }


}
