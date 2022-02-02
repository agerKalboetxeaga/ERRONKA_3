﻿using GodRun_API_el_bueno_.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Services
{
    public class InkestaService : IInkestaService
    {
        private readonly GodRunDbContext _context;

        public InkestaService(GodRunDbContext context)
        {
            _context = context;
        }

        public async Task InkestaGehitu(Inkesta inkesta)
        {
            _context.Inkesta.Add(inkesta);
            _context.SaveChanges();
        }
    }
}
