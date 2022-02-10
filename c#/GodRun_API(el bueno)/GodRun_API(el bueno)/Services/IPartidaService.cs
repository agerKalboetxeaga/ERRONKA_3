using GodRun_API_el_bueno_.Models;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Services
{
    /// <summary>
    /// Interface class for the service of Partidak
    /// </summary>
    public interface IPartidaService
    {
        Task<IList<Partida>> GetMota(int id);

        Task<IList<Partida>> GetIzena(string izena);

        Task<IList<Partida>> GetPartidas();

        Task<IList<Partida>> GetHoF();

        Task<IList<Partida>> GetHoS();
    }
}
