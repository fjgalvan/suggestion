package connection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MyClassLoader {
	public static final String rutaInterfazConexion ="connection.IConnector";
	public static final String metodoConectarseDeLaInterfaz ="conectarse";
	public static final String metodogetPromoDeLaInterfaz ="getPromo";
	File dir;
//	public MyClassLoader(File dir) throws ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
//		this.dir= dir; 
//	}
	
	public <GENERIC> List<GENERIC> load(File dir)
			throws ClassNotFoundException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IllegalAccessException {
			ArrayList listaDeMecanismos = new ArrayList<GENERIC>();
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					load(file);
				} else {
					String nameArchivo= file.getCanonicalPath();
					if(isNombreFileAClass(nameArchivo)){
						String nombrePaqueteClase= buscarNombrePaqueteClase(file);
						try {
						String classToLoad = nombrePaqueteClase;
						// Convert File to a URL
						URL url = this.dir.toURI().toURL();
						URL[] urls = new URL[] { url };
						@SuppressWarnings("resource")
						ClassLoader cl = new URLClassLoader(urls);
						Class<?> cls = cl.loadClass(classToLoad);
						// Obtengo el Objeto de la clase
						GENERIC instance = (GENERIC) cls.newInstance();
						if (Class.forName(rutaInterfazConexion).isInstance(instance)){
							listaDeMecanismos.add(instance);
						}

						} catch (ClassNotFoundException | MalformedURLException
								| InstantiationException
								| IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaDeMecanismos;
	}
	
	private boolean isNombreFileAClass(String nombreFile) {
		return (nombreFile.endsWith(".class"));
	}
	
	
	private String buscarNombrePaqueteClase(File file) {
		String nombrePaqueteClase = "";
		String nombreParent = file.getParent().toString();
		String nombreClass = file.getName().toString();

		String separador = Pattern.quote("\\");
		String[] parts = nombreParent.split(separador);
		String partPaquete = parts[2];

		String separador2 = Pattern.quote(".");
		String[] parts2 = nombreClass.split(separador2);
		String partClase = parts2[0];

		nombrePaqueteClase = partPaquete + "." + partClase;

		return nombrePaqueteClase;
	}
	
	//////////////////////////
	public <C> C load(String pathName, String className) {
		   List<File> jars = this.findJars(pathName);
		   if (jars.isEmpty())
		       return null;
		   try {
		       URL[] urls = this.buildUrls(jars);
		       URLClassLoader childClassLoader = new URLClassLoader(urls);
		       return (C) Class.forName(className, true, childClassLoader).newInstance();
		   } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | MalformedURLException c) {
		       throw new RuntimeException("Error cargando la clase " + className);
		   }
		}

		private URL[] buildUrls(List<File> files) throws MalformedURLException {
		   URL[] urls = new URL[files.size()];
		   for (int i = 0; i < files.size(); i++) {
		       urls[i] = files.get(i).toURI().toURL();
		   }
		   return urls;
		}

		private List<File> findJars(String pathName) {
		   File file = new File(pathName);
		   File[] files = Optional.of(file).map(File::listFiles).orElse(new File[]{});
		   return Arrays.asList(files).stream().filter(i->i.getPath().endsWith(".jar")).collect(Collectors.toList());
		}


}
