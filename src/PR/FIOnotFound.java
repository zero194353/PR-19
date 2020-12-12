public class FIOnotFound extends Exception
{
    public FIOnotFound(InnMain client)
    {
        super("ФИО клиента "+client.getName()+" не найдено.");
    }
}
