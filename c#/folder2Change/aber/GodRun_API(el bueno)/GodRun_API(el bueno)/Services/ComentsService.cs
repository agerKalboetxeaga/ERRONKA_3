using GodRun_API_el_bueno_.Models;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Services
{
    public class ComentsService : IComentsService
    {
        private readonly GodRunDbContext _context;

        public ComentsService(GodRunDbContext context)
        {
            _context = context;
        }
        public async Task KomentarioaGehitu(Comments comment)
        {
            _context.Add(comment);
        }

        public async Task<List<Comments>> KomentarioakIkusi() //awaits quitaus y el Ienumerable quitau taen
        {
            return _context.Comments.ToList();
        }

        public async Task<List<Comments>> KomentarioakIkusiLangilea(string jokalaria)
        {
            return _context.Comments.Where(c => c.jokalaria == jokalaria).ToList();
        }

        
    }
}
