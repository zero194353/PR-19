public class InnMain
{
    private String INN;
    private String name;

    public InnMain(String INN, String name)
    {
        this.INN = INN;
        this.name = name;
    }

    public String getINN()
    {
        return INN;
    }

    public String getName()
    {
        return name;
    }

    static String[] fiobase = new String[]
            {"Чивирёв В.И.", "Чивилёва И.В.", "Корсиков И.А."};

    static String[] innbase = new String[]
            {"96540756298", "143576549876", "653245353417"};

    public void CheckINN(String inn, String name) throws PR-19.INNnotFound, PR-19.FIOnotFound
    {
        int a = 0;
        for (int i = 0; i < 3; i++)
        {
            if(name == fiobase[i])
            {
                if(inn != innbase[i])
                    throw new PR-19.INNnotFound(this);
                break;
            }
            else if(name != fiobase[i])
            {
                a++;
            }
        }
        if (a == 3)
        {
            throw new PR-19.FIOnotFound(this);
        }
    }

    public static void Check(InnMain acc)
    {
        try
        {
            acc.CheckINN(acc.getINN(), acc.getName());
            System.out.println("ИНН клиента " + acc.getName() + " совпадает с базой данных.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());;
        }
    }

    public static void main(String[] args)
    {
        InnMain client = new InnMain("96540756298","Чивирёв В.И.");
        InnMain.Check(client);

        InnMain client1 = new InnMain("143576549876","Чивилёва И.В.");
        InnMain.Check(client1);

        InnMain client2 = new InnMain("653245353417","Корсиков И.А.");
        InnMain.Check(client2);

        InnMain client3 = new InnMain("653245353417","Иванов А.В.");
        InnMain.Check(client3);

        InnMain client4 = new InnMain("123","Корсиков И.А.");
        InnMain.Check(client4);
    }
}