select site,count(site) from site
  group by site ;

select site,translation, count(site) from site
  group by site, translation ;

select site,count(site) from site
  group by site;

select site,count(site) as counts from site
  group by site having count(site)> 1 order by counts desc ;

select site,count(case when length(translation)> 1 then 1 else 0 end) as counts from site
  group by site order by counts desc;