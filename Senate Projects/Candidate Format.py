import pathlib
import xlwt

def readfile(filename):
    with open(filename) as f:
        for line in f:
            yield line

def group_lines(lines):
    groups = [[]]
    new_group = False
    for line in lines:
        line = line.strip()
        if new_group:
            groups.append([line])
        else:
            groups[-1].append(line)
        new_group = len(line) > 15 and line[0:16] == 'Total Number of '
    return groups

def remove_misformatted(groups):
    for group in groups:
        if (len(group) - 2) % 4 != 0:
            write_error(group, 'Incorrect number of lines in group')
        else:
            yield group

def clear_error_file():
    with open(output, 'w') as f:
        f.write('')

def write_error(group, message=''):
    with open(output, 'a') as f:
                f.write(f'\n\nMisformatted group in {filename}\n{message}')
                for line in group:
                    f.write(f'\n{line}')

def extract_candidates(groups):
    for group in groups:
        for candidate in create_candidates(group):
            yield candidate

def create_candidates(group):
    # --------------------EXAMPLE GROUP---------------------------------
    # Office : STATE SENATOR DISTRICT 1 Incumbent: André Jacque
    # 0106603 Andrea Gage-Michaels
    # 2103 ROCK RIVER CT
    # DE PERE, WI 54115
    # Democratic
    # 0104808 André Jacque
    # 1615 LOST DAUPHIN RD
    # DE PERE, WI 54115
    # Republican
    # Total Number of STATE SENATOR DISTRICT 1 Candidates :2
    # -------------------------------------------------------------------
    
    # Extract the incumbent and title from the first line
    incumbent_loc = group[0].find('Incumbent: ')
    incumbent = group[0][incumbent_loc + len('Incumbent: '):]
    title = group[0][len('Office : '):incumbent_loc]

    # Return a candidate object for each candidate in the group
    for i in range(1, len(group) - 2, 4):
        # if splitting the first line on spaces does not produce
        # 3 elements, then the candidate name is not formatted correctly
        name = format_name(group[i])
        if name == None:
            write_error(group, f'Incorrectly formatted name: {group[i]}')
            continue
        if len(group[i+2]) == 0:
            write_error(group, f'Incorrectly formatted address: {group[i+2]}')
            continue
        
        yield Candidate(name, title, incumbent, group[i:i+4])

def format_name(line):
    sections = line.split()
    
    if sections[0].isnumeric():
        sections.pop(0)
    
    if len(sections) < 2:
        return None

    if len(sections[1]) == 2 and sections[1][1] == '.':
        sections.pop(1)

    if len(sections) > 2:
        sections = sections[0:2]
    
    return sections[0] + ' ' + sections[1]

class Candidate:
    def __init__(self, name, title, incumbent, lines):
        self.is_incumbent = name == incumbent
        self.first_name, self.last_name = name.split(' ')
        self.title = title
        self.party = lines[3]
        self.city = lines[2].split(',')[0]
        self.zipcode = lines[2].split(' ')[-1]
        self.address1 = lines[1]
        self.address2 = lines[2]
        
    def __str__(self):
        properties = ['title', 'first_name', 'last_name', 'address1', 'address2', 'party', 'city', 'zipcode', 'is_incumbent']
        return '|'.join([str(getattr(self, p)) for p in properties])

def save_candidates(candidates):
    wb = xlwt.Workbook()
    ws = wb.add_sheet('Candidates')
    ws.write(0, 0, 'Title')
    ws.write(0, 1, 'First Name')
    ws.write(0, 2, 'Last Name')
    ws.write(0, 3, 'Address 1')
    ws.write(0, 4, 'Address 2')
    ws.write(0, 5, 'Party')
    ws.write(0, 6, 'City')
    ws.write(0, 7, 'Zipcode')
    ws.write(0, 8, 'Is Incumbent')
    row = 1
    for candidate in candidates:
        ws.write(row, 0, candidate.title)
        ws.write(row, 1, candidate.first_name)
        ws.write(row, 2, candidate.last_name)
        ws.write(row, 3, candidate.address1)
        ws.write(row, 4, candidate.address2)
        ws.write(row, 5, candidate.party)
        ws.write(row, 6, candidate.city)
        ws.write(row, 7, candidate.zipcode)
        ws.write(row, 8, candidate.is_incumbent)
        row += 1

        wb.save('candidates.xls')
        
def main():
    path = pathlib.Path(__file__).parent.absolute()
    global filename
    global output
    filename = path / 'candidates.txt'
    output = path / 'output.txt'
    clear_error_file()
    lines = readfile(filename)
    groups = group_lines(lines)
    groups = remove_misformatted(groups)
    candidates = extract_candidates(groups)
    save_candidates(candidates)

if __name__ == '__main__':
    main()