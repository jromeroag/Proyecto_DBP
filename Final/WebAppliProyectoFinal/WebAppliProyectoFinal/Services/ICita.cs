using WebAppliProyectoFinal.Models;

namespace WebAppliProyectoFinal.Services
{
    public interface ICita
    {
        void add(Citum obj);
        IEnumerable<Citum> GetCitas();
        void remote(int id);
        Citum edit(int id);
        void editDetails(Citum obj);
    }
}
