from bs4 import BeautifulSoup
import urllib

f = urllib.urlopen('http://pokemondb.net/pokedex/stats/height-weight')
soup = BeautifulSoup(f.read())
with open('scripts/output.sql', 'w') as output_file:
    for row in soup.table.find_all('tr'):
        if len(row.find_all('td')) <= 0:
            continue
        number = repr(int(row.find_all('td')[0].contents[1]))
        weight = row.find_all('td')[4].string.split(' ')[0].encode('utf-8')
        name = row.find_all('td')[1].contents[0].string.encode('utf-8')
        if len(row.find_all('td')[1].contents) > 1:
            sub_name = row.find_all('td')[1].contents[1].string
            name += ' (' + sub_name + ')'
        insert_stmt = ('insert into pokemon values (' + number + ', ' +
                          "'" + name + "'" + ', ' +
                          weight + ');')
        output_file.write(insert_stmt + "\n")