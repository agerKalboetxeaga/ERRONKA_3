using GodRun_API_el_bueno_.Models;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Services
{
    public interface IComentsService
    {
        Task KomentarioaGehitu(Comments comment);

        Task<List<Comments>>KomentarioakIkusi();

        Task<List<Comments>> KomentarioakIkusiLangilea(string jokalaria);

    }
}
