using GodRun_WebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_WebApi.Services
{
    public interface IPartidaService
    {
        Task<IList<Partida>> GetMota(int id);

        Task<IList<Partida>> GetIzena(string izena);

        Task<IList<Partida>> GetPartidas();
    }
}
