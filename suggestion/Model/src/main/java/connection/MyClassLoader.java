package connection;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MyClassLoader {
	private static final String msgError = "Error, revise si existen esas clases en el pathFile! ";
	private static final String extentionJars = ".jar";

	public MyClassLoader() {
	}

	@SuppressWarnings("unchecked")
	public <GENERIC> List<GENERIC> load(String pathFile,
		List<String> classesToLoad) {
		List<File> filejars = findFileJars(pathFile);
		List<GENERIC> classes = new ArrayList<GENERIC>();
		if (filejars.isEmpty())
			return null;
		try {
			URL[] urlsList = getUrls(filejars);
			// carga todas las URL que toman de los .jar
			URLClassLoader childClassLoader = new URLClassLoader(urlsList);
			for (String className : classesToLoad) {
				classes.add((GENERIC) Class.forName(className, true,
						childClassLoader).newInstance());
			}
			return classes;
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | MalformedURLException c) {
			throw new RuntimeException(msgError + classesToLoad);
		}
	}

	private List<File> findFileJars(String pathFile) {
		File fileJar = new File(pathFile);
		File[] fileList = Optional.of(fileJar).map(File::listFiles)
				.orElse(new File[] {});
		return Arrays.asList(fileList).stream()
				.filter(i -> i.getPath().endsWith(extentionJars))
				.collect(Collectors.toList());
	}

	private URL[] getUrls(List<File> filejars) throws MalformedURLException {
		URL[] urlsList = new URL[filejars.size()];
		for (int i = 0; i < filejars.size(); i++) {
			urlsList[i] = filejars.get(i).toURI().toURL();
		}
		return urlsList;
	}
}
