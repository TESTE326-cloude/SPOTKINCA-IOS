import os
from PIL import Image

logo_path = r"D:\Documentos\SPOTKINCA\logo.jpg"
res_dir = r"D:\Documentos\SPOTKINCA\SimpMusic-repo\androidApp\src\main\res"

sizes = {
    "mipmap-mdpi": 48,
    "mipmap-hdpi": 72,
    "mipmap-xhdpi": 96,
    "mipmap-xxhdpi": 144,
    "mipmap-xxxhdpi": 192
}

if os.path.exists(logo_path):
    img = Image.open(logo_path).convert("RGBA")
    for folder, size in sizes.items():
        folder_path = os.path.join(res_dir, folder)
        os.makedirs(folder_path, exist_ok=True)
        resized = img.resize((size, size), Image.Resampling.LANCZOS)

        resized.save(os.path.join(folder_path, "ic_launcher.png"), "PNG")
        resized.save(os.path.join(folder_path, "ic_launcher_round.png"), "PNG")
        resized.save(os.path.join(folder_path, "ic_launcher_foreground.png"), "PNG")
        resized.save(os.path.join(folder_path, "ic_launcher_round_foreground.png"), "PNG")
        print(f"Updated {folder} ({size}x{size})")
    print("Logo updated successfully across all mipmap densities!")
else:
    print(f"Error: Logo not found at {logo_path}")
