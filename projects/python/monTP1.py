import csv
from datetime import datetime
import statistics

def load_data(file_path):
    data = []
    try:
        with open(file_path, 'r', encoding='utf-16le') as file:
            reader = csv.DictReader(file, delimiter='\t')
            for row in reader:
                data.append(row)
        return data
    except FileNotFoundError:
        print(f"Archivo no encontrado: {file_path}")
        return None
    except Exception as e:
        print(f"Error al leer el archivo: {e}")
        return None

def display_menu():
    print("1- Lire le fichier de données et présenter les statistiques sommaires")
    print("2- Afficher les statistiques descriptives pour un arrondissement en particulier")
    print("3- Créer un rapport général")
    print("Entrez un numéro pour choisir une option ou appuyez sur 'q' pour quitter : ")

def main():
    file_name = "Ruelles-vertes.txt"
    data = load_data(file_name)
    if data is None:
        return
    
    display_menu()
    choix = input()
    while choix != 'q':
        if choix == '1':
            print(f"Nom de fichier lu est: {file_name}")
            print(f"Le nombre de lignes du fichier lu est : {len(data)}")
            if len(data) > 0:
                print(f"Le nombre de colonnes du fichier lu est : {len(data[0])}")
                print(f"Les 5 premières lignes du fichier lu sont :")
                for i in range(min(5, len(data))):
                    print(data[i], end='\n\n')
                superficies = [float(row['SUPERFICIE_RUELLE_M2'].replace(',', '.')) for row in data]
                print("La surface la plus petite est: ", min(superficies), "m2")
                print("La surface la plus grande est: ", max(superficies), "m2")
                print("Top 3 des arrondissements avec le plus grand nombre de ruelles vertes enregistrées:")
                arrondissements = {}
                for row in data:
                    arrondissement = row['PROPRIETAIRE_REF']
                    if arrondissement in arrondissements:
                        arrondissements[arrondissement] += 1
                    else:
                        arrondissements[arrondissement] = 1
                if arrondissements:
                    top_arrondissements = sorted(arrondissements.items(), key=lambda x: x[1], reverse=True)[:3]
                    for i, (arrondissement, count) in enumerate(top_arrondissements, 1):
                        print(f"{i}. Arrondissement: {arrondissement}, Nombre de ruelles vertes: {count}")              
        elif choix == '2':
            print("Afficher les statistiques descriptives pour un arrondissement en particulier")
            arrondissementCode = input("Entrez le code de l'arrondissement : ")

            filtered_data = [row for row in data if row.get('CODE_ARR') == arrondissementCode]

            if filtered_data:
                superficies = [float(row['SUPERFICIE_RUELLE_M2'].replace(',', '.')) for row in filtered_data if row.get('SUPERFICIE_RUELLE_M2')]
                if superficies:
                    circulation_types = {
                        "Ouverte": 0,
                        "Fermée": 0,
                        "Partiellement fermée": 0,
                        "Autres": 0
                    }
                    for row in filtered_data:
                        circulation = row.get('CIRCULATION', 'Autres')
                        if circulation in circulation_types:
                            circulation_types[circulation] += 1
                        else:
                            circulation_types['Autres'] += 1
                    
                    print(f"1- Total des ruelles vertes par type de circulation :")
                    for type_circulation, count in circulation_types.items():
                        print(f"• {type_circulation} : {count}")
                    
                    print(f"2- Total de ruelles vertes enregistrées dans cet établissement : {len(superficies)}")
                    print(f"3- Superficie totale des ruelles vertes de cet arrondissement : {sum(superficies)} m2")
                else:
                    print(f"Aucune donnée de superficie trouvée pour l'arrondissement {arrondissementCode}.")
            else:
                print(f"Aucune donnée trouvée pour l'arrondissement {arrondissementCode}.")
        elif choix == '3':
            print("Créer un rapport général")
            arrondissements = {}
            for row in data:
                arrondissement = row.get('CODE_ARR')
                superficie = row.get('SUPERFICIE_RUELLE_M2')
                if arrondissement and superficie:
                    superficie = float(superficie.replace(',', '.'))
                    if arrondissement in arrondissements:
                        arrondissements[arrondissement].append(superficie)
                    else:
                        arrondissements[arrondissement] = [superficie]
            try:
                with open("rapportGeneral.txt", 'w', encoding='utf-8') as report:
                    report.write("Rapport général de tous les arrondissements\n")
                    report.write(f"Date de création : {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}\n\n")
                    
                    for arrondissement, superficies in arrondissements.items():
                        report.write(f"Arrondissement : {arrondissement}\n")
                        report.write(f"Nombre total de ruelles : {len(superficies)}\n")
                        report.write(f"Superficie totale : {sum(superficies)} m2\n")
                        report.write(f"Superficie moyenne : {statistics.mean(superficies)} m2\n")
                        report.write(f"Superficie minimale : {min(superficies)} m2\n")
                        report.write(f"Superficie maximale : {max(superficies)} m2\n")
                        report.write("\n")

                    print("Le rapport général a été créé avec succès.")
            except Exception as e:
                print(f"Error al crear el informe: {e}")
        else:
            print("Option invalide")
        display_menu()
        choix = input()
    print("Au revoir!")

if __name__ == '__main__':
    main()
