# Python script to filter lines in error.txt

def filter_failed_lines(input_file, output_file):
    with open(input_file, 'r') as infile:
        lines = infile.readlines()

    filtered_lines = []
    i = 0
    while i < len(lines):
        if lines[i].startswith("%FAILED"):
            filtered_lines.append(lines[i])
            # Add the next 5 lines (if available)
            for j in range(1, 6):
                if i + j < len(lines):
                    filtered_lines.append(lines[i + j])
            i += 6  # Skip the next 5 lines since they were already added
        else:
            i += 1

    with open(output_file, 'w') as outfile:
        outfile.writelines(filtered_lines)

# Specify input and output file paths
filter_failed_lines('errors.txt', 'filtered_error.txt')