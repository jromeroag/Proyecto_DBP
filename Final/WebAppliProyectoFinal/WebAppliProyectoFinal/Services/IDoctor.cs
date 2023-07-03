using WebAppliProyectoFinal.Models;

namespace WebAppliProyectoFinal.Services
{
    public interface IDoctor
    {
        void add(Doctor obj);
        void remove(int id);
        void editaDetails(Doctor obj);
        Doctor edit(int id);
        IEnumerable<Doctor> GetAllDoctor();
    }
}
