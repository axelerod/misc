select * from site  where
  length(translation) =
  (select max(length(translation)) from site);

select top 1 * from site
  order by length(translation) desc;

select site,count(case when length(translation)> 1 then 1 else 0 end) as counts from site
  group by site order by counts desc