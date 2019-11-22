package FileParseService;

import java.util.HashMap;

 public class Service {
    HashMap<String,String> solvedMap;
    public Service(HashMap<String, String> objectMap)
    {
        solvedMap=objectMap;
    }

    public HashMap<String,String> serviceSolver()
    {
        return solvedMap;
    }

}
