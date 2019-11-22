import java.util.HashMap;

class Service {
    HashMap<String,String> solvedMap;
    Service(HashMap<String, String> objectMap)
    {
        solvedMap=objectMap;
    }

    HashMap<String,String> serviceSolver()
    {
        return solvedMap;
    }

}
